package com.example.android_hw3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_hw3.R
import com.example.android_hw3.adapter.InstaAdapter
import com.example.android_hw3.data.InstaData
import com.example.android_hw3.itemDecoration
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    lateinit var instaAdapter : InstaAdapter
    val datas = mutableListOf<InstaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter //리사이클러뷰의 어댑터를 instaAdapter로 지정해줌
        loadDatas() //데이터를 임의로 생성하고 어댑터에 전달
    }

    private fun loadDatas() {
        datas.apply {
            add(
                InstaData(
                    userName = "박세곤",
                    img_profile = "https://cdn.pixabay.com/photo/2018/10/03/05/32/logo-3720472__340.jpg",
                    img_contents = "https://image.shutterstock.com/image-photo/young-man-break-dancing-night-260nw-496949095.jpg"

                ))

            add(
                InstaData(
                    userName = "박혜린",
                    img_profile = "https://cdn.pixabay.com/photo/2017/08/03/11/28/ferris-wheel-2575709__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2016/01/22/16/42/eiffel-tower-1156146__340.jpg"

                ))

            add(
                InstaData(
                    userName = "박지혜",
                    img_profile = "https://cdn.pixabay.com/photo/2016/01/09/18/28/old-1130742__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2018/11/29/21/19/hamburg-3846525__340.jpg"

                ))

        }
        rv_home.addItemDecoration(itemDecoration(5))
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged() //데이터가 갱신되었음을 어댑터에 알려주는 역할

    }

}
