package com.example.app_mvvm.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.app_mvvm.R;
import com.example.app_mvvm.databinding.ActivityMainBinding;
import com.example.app_mvvm.viewmodels.LoginViewModel;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// ViewModelmet à jour le Modèle
// après avoir observé les changements dans la vue
// Le modèle met également à jour la vue
// via le ViewModel
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();
    }
    // toute modification de l'attribut toastMessage
// définie sur le bouton avec le préfixe bind
// invoque cette méthode
    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}