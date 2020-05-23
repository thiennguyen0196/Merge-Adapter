package com.example.merge_adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.example.merge_adapter.adapter.BannerAdapter
import com.example.merge_adapter.adapter.LeftAdapter
import com.example.merge_adapter.adapter.RightAdapter
import com.example.merge_adapter.data.DataFactory
import com.example.merge_adapter.data.model.Banner
import com.example.merge_adapter.data.model.User
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mergeAdapter: MergeAdapter

    private lateinit var leftAdapter: LeftAdapter
    private lateinit var rightAdapter: RightAdapter
    private lateinit var bannerAdapter: BannerAdapter

    private lateinit var listLeftAdapter: List<User>
    private lateinit var listRightAdapter: List<User>
    private lateinit var listBannerAdapter: List<Banner>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fresco.initialize(applicationContext)

        setContentView(R.layout.activity_main)

        setupDataInRecyclerView()
        submitData()

        btnLeftAdapter.setOnClickListener {
            leftAdapter.submitList(ArrayList<User>().apply {
                addAll(leftAdapter.currentList)
                add(DataFactory.getUser()[(0..2).random()])
            })
        }
        btnRightAdapter.setOnClickListener {
            rightAdapter.submitList(ArrayList<User>().apply {
                addAll(rightAdapter.currentList)
                add(DataFactory.getUser()[(0..2).random()])
            })
        }
        btnBannerAdapter.setOnClickListener {
            bannerAdapter.submitList(DataFactory.getBanner(seed = (0..1).random()))
        }
    }

    private fun setupDataInRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)

        leftAdapter = LeftAdapter()
        rightAdapter = RightAdapter()
        bannerAdapter = BannerAdapter()

        mergeAdapter = MergeAdapter(leftAdapter, bannerAdapter, rightAdapter)
        recyclerView.adapter = mergeAdapter
    }

    private fun submitData() {
        listLeftAdapter = DataFactory.getUser()
        listRightAdapter = DataFactory.getUser().reversed()
        listBannerAdapter = DataFactory.getBanner()

        leftAdapter.submitList(listLeftAdapter)
        rightAdapter.submitList(listRightAdapter)
        bannerAdapter.submitList(listBannerAdapter)
    }
}
