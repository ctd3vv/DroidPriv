package io.github.ctd3vv.droidpriv;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import java.io.File;

public class RootFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_root, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView cardStatus = view.findViewById(R.id.cardStatus);
        TextView txtStatus = view.findViewById(R.id.txtStatus);

        ((TextView)view.findViewById(R.id.txtKernel)).setText(System.getProperty("os.version"));
        ((TextView)view.findViewById(R.id.txtAndroid)).setText(Build.VERSION.RELEASE);
        ((TextView)view.findViewById(R.id.txtModelo)).setText(Build.MODEL);

        updateStatus(cardStatus, txtStatus);
    }

    private void updateStatus(CardView card, TextView text) {
        if (canRunRootCommand()) {
            text.setText("FULL ROOT ACCESS\nSystem permission granted.");
            card.setCardBackgroundColor(0xFF2E3D2E);
            text.setTextColor(0xFFACF2AF);
        } else if (hasRootApps()) {
            text.setText("ROOT MANAGER DETECTED\nMagisk or KernelSU found.");
            card.setCardBackgroundColor(0xFF3D322E);
            text.setTextColor(0xFFF2C9AC);
        } else if (hasSuBinary()) {
            text.setText("SU BINARY FOUND\nBinary detected in system paths.");
            card.setCardBackgroundColor(0xFF3D3D2E);
            text.setTextColor(0xFFF2F2AC);
        } else {
            text.setText("CLEAN SYSTEM\nNo traces detected.");
            card.setCardBackgroundColor(0xFF3D2E2E);
            text.setTextColor(0xFFF2ACAC);
        }
    }

    private boolean canRunRootCommand() {
        try {
            Process p = Runtime.getRuntime().exec("su -c id");
            p.destroy();
            return true;
        } catch (Exception e) { return false; }
    }

    private boolean hasRootApps() {
        String[] pkgs = {"com.topjohnwu.magisk", "me.tiann.kernelsu", "com.noshufou.android.su", "com.sukisu.ultra"};
        PackageManager pm = getContext().getPackageManager();
        for (String pkg : pkgs) {
            try { pm.getPackageInfo(pkg, 0); return true; } catch (Exception e) { }
        }
        return false;
    }

    private boolean hasSuBinary() {
        String[] paths = {"/system/bin/su", "/system/xbin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su"};
        for (String path : paths) { if (new File(path).exists()) return true; }
        return false;
    }
}