package com.example.android_hw3.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_hw3.R
import com.example.android_hw3.data.RequestLogin
import com.example.android_hw3.makeToast
import com.example.android_hw3.makeToast2
import com.example.android_hw3.network.RequestToServer
import com.example.android_hw3.network.customEnqueue
import com.example.android_hw3.textChangedListener
import kotlinx.android.synthetic.main.activity_login_.*

class Login_Activity : AppCompatActivity() {
    val JOIN = 100
    val requestToServer : RequestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_)

//        sopt_id.textChangedListener {
//            if(it.isNullOrBlank()) {
//                makeToast("아이디가 빈칸이네요")
//            }
//        }

        btn_login.setOnClickListener {
            if(sopt_id.text.isNullOrBlank() || sopt_pwd.text.isNullOrBlank())
                makeToast2("아이디와 비밀번호를 모두 입력하세요.")
            else {
                requestToServer.service.requestLogin( //Call 타입이 리턴됨
                    RequestLogin(
                        id = sopt_id.text.toString(),
                        password = sopt_pwd.text.toString()
                    )//로그인 정보를 전달
                ).customEnqueue(
                    onError = {makeToast("올바르지 않은 요청입니다.")},
                    onSuccess = {
                        if(it.success) {
                            makeToast("로그인 성공")
                            val intent = Intent(this@Login_Activity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            makeToast2("아이디/비밀번호를 확인해주세요.")
                        }
                    }
                )


//                requestToServer.service.requestLogin( //Call 타입이 리턴됨
//                    RequestLogin(
//                        id = sopt_id.text.toString(),
//                        password = sopt_pwd.text.toString()
//                    )//로그인 정보를 전달
//                ).enqueue(object : Callback<ResponseLogin>{
//                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//                        //통신 실패
//                    }
//
//                    override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
//                        if(response.isSuccessful) {
//                            if(response.body()!!.success) {
//                                makeToast("로그인 성공")
//                                val intent = Intent(this@Login_Activity, MainActivity::class.java)
//                                startActivity(intent)
//                                finish()
//                            }
//                            else {
//                                makeToast("아이디/비밀번호를 확인해주세요.")
//                            }
//                        }
//                    }
//
//                })
            }
        }

        join.setOnClickListener {
            var intent = Intent(this, JoinActivity::class.java)
            startActivityForResult(intent, JOIN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == JOIN) {
            if(resultCode == Activity.RESULT_OK) {
                sopt_id.setText(data!!.getStringExtra("id"))
                sopt_pwd.setText(data!!.getStringExtra("password"))
                makeToast("회원가입에 성공했습니다.")
            }
        }
    }
}
