package com.example.helloworld

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    lateinit var imageView: ImageView
    val url="https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button=findViewById<Button>(R.id.helloButton)
        button.setOnClickListener{
            Toast.makeText(this, "Hello to you! Woof woof!", Toast.LENGTH_SHORT).show()
        }
        val barks=findViewById<Button>(R.id.barkButton)

        barks.setOnClickListener {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.bark)
                mMediaPlayer!!.isLooping = true
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()
            //stopSound()
        }
        val treats=findViewById<Button>(R.id.treatButton)

        treats.setOnClickListener {
            if (mMediaPlayer != null) {
                mMediaPlayer!!.stop()
                mMediaPlayer!!.release()
                mMediaPlayer = null
            }
        }

    }


}