package com.example.ch11_gridview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "그리드뷰 영화 포스터"

        var gv = findViewById<View>(R.id.gridView1) as GridView
        var gAdapter = MyGridAdapter(this)
        gv.adapter = gAdapter


    }

    inner class MyGridAdapter(var context: Context) : BaseAdapter() {

        // 뷰 생성
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageview = ImageView(this@MainActivity)
            imageview.layoutParams = ViewGroup.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5,5,5,5)

            imageview.setImageResource(posterID[p0])

            imageview.setOnClickListener {
                var dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
                var dlg = AlertDialog.Builder(this@MainActivity)
                var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
                ivPoster.setImageResource(posterID[p0])

                dlg.setTitle(posterName[p0])
                dlg.setIcon(R.drawable.movie_icon)
                dlg.setView(dialogView)
                dlg.setNegativeButton("닫기", null)
                dlg.show()
            }

            return imageview
        }
        // 그리드뷰에 보일 이미지 갯수
        override fun getCount(): Int {
            return posterID.size
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        var posterID = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
        )

        var posterName = arrayOf(
            "써니", "완득이", "괴물", "라디오 스타", "비열한 거리",
            "왕의 남자", "아일랜드", "웰컴 투 동막골", "헬보이", "백 투더 퓨처"
        )

    }
}