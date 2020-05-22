package com.example.android_hw3.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_hw3.R
import com.example.android_hw3.data.RequestJoin
import com.example.android_hw3.data.ResponseJoin
import com.example.android_hw3.makeToast
import com.example.android_hw3.makeToast2
import com.example.android_hw3.network.RequestToServerJoin
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {
    val requestToServerJoin : RequestToServerJoin = RequestToServerJoin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        btn_join.setOnClickListener {
            if(new_id.text.isNullOrBlank() || new_pwd.text.isNullOrBlank() || check_pwd.text.isNullOrBlank() || name.text.isNullOrBlank()) {
                makeToast("모든 값을 입력했는지 확인하세요.")
            }
            else {
                requestToServerJoin.service.requestJoin(
                    RequestJoin(
                        id = new_id.text.toString(),
                        password = new_pwd.text.toString(),
                        name = name.text.toString(),
                        email = new_email.text.toString(),
                        phone = phone_num.text.toString()
                    )
                ).enqueue(object : Callback<ResponseJoin>{
                    override fun onFailure(call: Call<ResponseJoin>, t: Throwable) {
                        //통신 실패
                    }

                    override fun onResponse(call: Call<ResponseJoin>, response: Response<ResponseJoin>) {
                        if(response.isSuccessful) {
                            if(response.body()!!.success) {
                                makeToast("회원가입 성공!")
                                val intent = Intent()
                                intent.putExtra("id", new_id.text.toString())
                                intent.putExtra("password", new_pwd.text.toString())
                                setResult(Activity.RESULT_OK, intent)
                                finish()
                            }
                        }
                    }

                })

            }
        }
    }
}
