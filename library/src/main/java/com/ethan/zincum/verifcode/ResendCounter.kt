package com.ethan.zincum.verifcode

import android.os.Handler
import android.os.Looper

/**
 * 计数器
 *
 * @version 0.1
 *
 *
 * Created by zxj on 2/8/2018.
 */
class ResendCounter private constructor(handler: Handler, start: Int, end: Int, step: Int, interval: Int, listener: Listener) {
    private val listener: Listener
    private val handler: Handler?
    private val step: Int
    private val start: Int
    private val end: Int
    private val interval: Int
    private var current: Int
    private val runnable = Runnable { next() }

    init {
        this.handler = handler
        this.listener = listener
        this.start = start
        this.step = step
        this.end = end
        this.interval = interval
        current = start
        if ((start - end) * step >= 0) {
            listener.complete()
        }
    }

    fun start() {
        next()
    }

    private operator fun next() {
        if ((current - end) * step < 0) {
            current += if (current != start) {
                listener.update(current)
                step
            } else {
                step
            }
            handler!!.postDelayed(runnable, interval.toLong())
        } else {
            listener.complete()
        }
    }

    fun stop() {
        handler?.removeCallbacks(runnable)
    }

    interface Listener {
        fun update(count: Int)
        fun complete()
    }

    companion object {
        fun create(start: Int, end: Int, step: Int, interval: Int, listener: Listener): ResendCounter {
            return ResendCounter(Handler(Looper.getMainLooper()), start, end, step, interval, listener)
        }

        fun create(handler: Handler, start: Int, end: Int, step: Int, interval: Int, listener: Listener): ResendCounter {
            return ResendCounter(handler, start, end, step, interval, listener)
        }
    }
}