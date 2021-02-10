package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.swoosh.EXTRA_LEAGUE
import com.example.swoosh.EXTRA_SKILL
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league : String? = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBallerClicked(view: View) {
        beginnerSkillButton.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillButton.isChecked = false
        skill = "beginner"
    }

    fun onSkillFinishClicked(view: View) {
        if(skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            val toast = Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM, 0, 250)
            toast.show()
        }
    }
}