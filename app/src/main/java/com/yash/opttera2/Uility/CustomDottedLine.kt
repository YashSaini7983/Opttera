package com.yash.opttera2.Uility

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomDottedLine (context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint().apply {
        color = 0xFF000000.toInt() // Change this to the desired color
        strokeWidth = 5f // Change this to the desired thickness
        style = Paint.Style.STROKE
    }
    private val dotRadius = 5f // Radius of the dots
    private val dotSpacing = 20f // Space between the dots

    override fun onDraw(canvas: Canvas) {
        if (canvas != null) {
            super.onDraw(canvas)
        }

        canvas?.let {
            var startY = 0f
            while (startY < height) {
                it.drawCircle(width / 2f, startY, dotRadius, paint)
                startY += dotSpacing
            }
        }
    }
}

