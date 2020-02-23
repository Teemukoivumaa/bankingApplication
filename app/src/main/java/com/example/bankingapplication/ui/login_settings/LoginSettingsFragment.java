package com.example.bankingapplication.ui.login_settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.bankingapplication.R;
import com.example.bankingapplication.ui.settings.SettingsViewModel;

public class LoginSettingsFragment extends Fragment {

    private LoginSettingsViewModel loginSettingsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginSettingsViewModel = ViewModelProviders.of(this).get(LoginSettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login_settings, container, false);

        return root;
    }
}