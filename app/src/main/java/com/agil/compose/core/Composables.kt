package com.agil.compose.core

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.compose.runtime.BroadcastFrameClock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Composition
import androidx.compose.runtime.ControlledComposition
import androidx.compose.runtime.DefaultMonotonicFrameClock
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.monotonicFrameClock
import androidx.compose.runtime.snapshots.Snapshot
import com.agil.compose.foundation.Modifier
import com.agil.compose.widget.ButtonNode
import com.agil.compose.widget.Column
import com.agil.compose.widget.ImageNode
import com.agil.compose.widget.Row
import com.agil.compose.widget.TextNode
import com.agil.compose.widget.ViewNode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun View(modifier: Modifier = Modifier()) {
    ComposeNode<ViewNode, ComposeAndroidApplier>(
        factory = { ViewNode(modifier) },
        update = {}
    )
}

@Composable
fun Text(text: String, modifier: Modifier = Modifier()) {
    ComposeNode<TextNode, ComposeAndroidApplier>(
        factory = { TextNode(modifier) },
        update = { set(text) { this.content = text } })
}

@Composable
fun Image(source: Any, modifier: Modifier = Modifier(), tintColor: String? = null) {
    ComposeNode<ImageNode, ComposeAndroidApplier>(
        factory = { ImageNode(modifier) },
        update = {
            set(source) { this.source = source }
            set(tintColor) { this.tintColor = tintColor }
        }
    )
}

@Composable
fun Button(text: String, onPress: (view: View) -> Unit, modifier: Modifier = Modifier()) {
    ComposeNode<ButtonNode, ComposeAndroidApplier>(
        factory = { ButtonNode(onPress, modifier) },
        update = { set(text) { this.content = text } })
}

@Composable
fun Row(modifier: Modifier = Modifier(), content: @Composable () -> Unit) {
    ComposeNode<Row, ComposeAndroidApplier>(
        factory = { Row(modifier) },
        update = {},
        content = content
    )
}

@Composable
fun Column(modifier: Modifier = Modifier(), content: @Composable () -> Unit) {
    ComposeNode<Column, ComposeAndroidApplier>(
        factory = { Column(modifier) },
        update = {},
        content = content
    )
}

fun runComposeAgil(content: @Composable () -> Unit) = runBlocking {
    val frameClock = BroadcastFrameClock()
    val recomposer = Recomposer(coroutineContext + frameClock)
    val rootNode = Column(Modifier())
    val composition = Composition(
        applier = ComposeAndroidApplier(rootNode),
        parent = recomposer
    )
    composition.setContent(content)
    return@runBlocking rootNode.view
}

fun runComposeAndroid(content: @Composable () -> Unit): View {
    val frameClock = BroadcastFrameClock()
    val recomposer = Recomposer(frameClock)
    val rootNode = Column(Modifier())
    val composition = ControlledComposition(
        applier = ComposeAndroidApplier(rootNode),
        parent = recomposer
    )
    val scope = CoroutineScope(AndroidUIDispatcher.Main)
    scope.launch {
        composition.setContent {
            content()
        }
        var snapshotJob: Job? = null
        val snapshotHandle = Snapshot.registerGlobalWriteObserver {
            if (snapshotJob == null) {
                snapshotJob = scope.launch {
                    snapshotJob = null
                    Snapshot.sendApplyNotifications()
                }
            }
        }
        val recomposeJob = scope.launch(start = CoroutineStart.UNDISPATCHED) {
            recomposer.runRecomposeAndApplyChanges()
        }
    }
    return rootNode.view
}