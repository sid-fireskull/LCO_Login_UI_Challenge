package com.learn.codeonline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    boolean isDark = false;
    private RelativeLayout splashScreen, loginScreen, signUpScreen;
    private LinearLayout loginHeaderBottomLine;
    private ImageView lcoLogo, lcologo2;
    private TextView title, loginTitle;
    private ImageView youtubeImageView, androidImageView;
    private Animation bottomSlide, scaleObject, fadeIn;
    private TextView loginLabel;
    // Login
    private TextInputLayout email, password;
    private Button loginBtn;
    private TextView notAMember, signUpBtn, forgotPassword;
    // Sign Up
    private TextInputLayout signUpEmail, signUpPassword, confirmSignUpPassword;
    private FloatingActionButton signUpFab;
    private ImageView signUpLCOLogo;
    private TextView signUpHeaderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.user_pref), Context.MODE_PRIVATE);
        isDark = sharedPreferences.getBoolean("isDark", false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (isDark) {
            setContentView(R.layout.activity_splash_screen_dark);
            editor.putBoolean("isDark", false);
        } else {
            setContentView(R.layout.activity_splash_screen_light);
            editor.putBoolean("isDark", true);
        }
        editor.apply();
        initView();
        animation();
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupAnimate();
            }
        });
    }

    private void initView() {
        splashScreen = findViewById(R.id.view_splashscreen_layout);
        loginScreen = findViewById(R.id.view_login_layout);
        signUpScreen = findViewById(R.id.view_signup_layout);
        loginHeaderBottomLine = findViewById(R.id.login_header_bottom_line);

        lcoLogo = findViewById(R.id.lco_light_logo_iv);
        title = findViewById(R.id.splash_screen_title_tv);
        loginTitle = findViewById(R.id.lco_label_tv2);
        youtubeImageView = findViewById(R.id.youtube_design_view);
        androidImageView = findViewById(R.id.android_design_view);
        lcologo2 = findViewById(R.id.lco_light_logo_2_iv);
        loginLabel = findViewById(R.id.login_title_label_tv);

        email = findViewById(R.id.input_layout_email);
        password = findViewById(R.id.input_layout_password);
        loginBtn = findViewById(R.id.login_btn);
        notAMember = findViewById(R.id.not_a_member_label);
        signUpBtn = findViewById(R.id.sign_up_btn);
        forgotPassword = findViewById(R.id.forgot_password_tv);

        signUpEmail = findViewById(R.id.sign_up_input_layout_email);
        signUpPassword = findViewById(R.id.sign_up_input_layout_password);
        confirmSignUpPassword = findViewById(R.id.sign_up_input_layout_confirm_password);
        signUpFab = findViewById(R.id.signup_submit_fab);
        signUpLCOLogo = findViewById(R.id.signup_lco_logo);
        signUpHeaderText = findViewById(R.id.signup_header_text);
    }

    private void animation() {
        lcologo2.setVisibility(View.GONE);
        loginTitle.setVisibility(View.GONE);
        loginLabel.setVisibility(View.GONE);

        email.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        loginBtn.setVisibility(View.GONE);
        notAMember.setVisibility(View.GONE);
        signUpBtn.setVisibility(View.GONE);
        forgotPassword.setVisibility(View.GONE);

        bottomSlide = AnimationUtils.loadAnimation(this, R.anim.bottom_slide);
        scaleObject = AnimationUtils.loadAnimation(this, R.anim.scale_object);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        splashScreen.animate().translationY(-1200).setDuration(800).setStartDelay(1500);
        youtubeImageView.animate().alpha(0).setDuration(800).setStartDelay(1300).withEndAction(new Runnable() {
            @Override
            public void run() {
                lcologo2.setVisibility(View.VISIBLE);
                lcologo2.startAnimation(bottomSlide);
                loginTitle.setVisibility(View.VISIBLE);
                loginTitle.startAnimation(bottomSlide);
                loginLabel.setVisibility(View.VISIBLE);
                loginLabel.startAnimation(scaleObject);
                email.setVisibility(View.VISIBLE);
                email.startAnimation(scaleObject);
                password.setVisibility(View.VISIBLE);
                password.setAnimation(scaleObject);
                loginBtn.setVisibility(View.VISIBLE);
                loginBtn.setAnimation(bottomSlide);
                notAMember.setVisibility(View.VISIBLE);
                notAMember.setAnimation(fadeIn);
                signUpBtn.setVisibility(View.VISIBLE);
                signUpBtn.setAnimation(fadeIn);
                forgotPassword.setVisibility(View.VISIBLE);
                forgotPassword.setAnimation(fadeIn);
            }
        });
        androidImageView.animate().alpha(0).setDuration(800).setStartDelay(1300);
        lcoLogo.animate().alpha(0).setDuration(800).setStartDelay(1500);
        title.animate().alpha(0).setDuration(800).setStartDelay(1500);

    }

    private void signupAnimate() {
        signUpLCOLogo.setVisibility(View.INVISIBLE);
        signUpHeaderText.setVisibility(View.INVISIBLE);
        signUpEmail.setVisibility(View.INVISIBLE);
        signUpPassword.setVisibility(View.INVISIBLE);
        confirmSignUpPassword.setVisibility(View.INVISIBLE);
        splashScreen.animate().translationY(-2100).setDuration(300).setStartDelay(200).withEndAction(
                new Runnable() {
                    @Override
                    public void run() {
                        loginLabel.animate().alpha(0).translationY(-800).setDuration(400);
                        email.animate().alpha(0).translationY(-800).setDuration(400);
                        password.animate().alpha(0).translationY(-800).setDuration(400);
                        loginHeaderBottomLine.animate().alpha(0).translationX(-800).setDuration(400);
                        loginBtn.animate().alpha(0).translationY(-800).setDuration(400);
                        notAMember.animate().alpha(0).translationX(-800).setDuration(400);
                        forgotPassword.animate().alpha(0).translationY(-800).setDuration(400);
                        signUpBtn.animate().alpha(0).translationX(800).setDuration(400);
                    }
                }
        );
        loginScreen.animate().translationY(-2100).setDuration(800).setStartDelay(800).withEndAction(
                new Runnable() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void run() {
                        signUpLCOLogo.setVisibility(View.VISIBLE);
                        signUpLCOLogo.startAnimation(bottomSlide);
                        signUpHeaderText.setVisibility(View.VISIBLE);
                        signUpHeaderText.startAnimation(bottomSlide);
                        signUpEmail.setVisibility(View.VISIBLE);
                        signUpEmail.startAnimation(bottomSlide);
                        signUpPassword.setVisibility(View.VISIBLE);
                        signUpPassword.startAnimation(bottomSlide);
                        confirmSignUpPassword.setVisibility(View.VISIBLE);
                        confirmSignUpPassword.startAnimation(bottomSlide);
                        signUpFab.setVisibility(View.VISIBLE);
                        signUpFab.startAnimation(fadeIn);
                    }
                }
        );
    }

}
