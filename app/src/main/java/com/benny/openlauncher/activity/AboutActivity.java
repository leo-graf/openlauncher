package com.benny.openlauncher.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.view.MenuItem;

import com.benny.openlauncher.R;
import com.danielstone.materialaboutlibrary.ConvenienceBuilder;
import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.model.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
import com.danielstone.materialaboutlibrary.model.MaterialAboutTitleItem;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.licenses.GnuLesserGeneralPublicLicense21;
import de.psdev.licensesdialog.licenses.MITLicense;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

public class AboutActivity extends MaterialAboutActivity {

    @Override
    protected MaterialAboutList getMaterialAboutList(Context context) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        });

        MaterialAboutCard.Builder titleCard = new MaterialAboutCard.Builder();
        titleCard.addItem(new MaterialAboutTitleItem(R.string.app_name, R.drawable.ic_launcher));
        try {
            titleCard.addItem(ConvenienceBuilder.createVersionActionItem(this, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_info_outline_24dp, null), "Version", true));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        titleCard.addItem(ConvenienceBuilder.createWebsiteActionItem(this, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_github, null), "GitHub", false, Uri.parse("https://github.com/BennyKok/OpenLauncher")));
        titleCard.addItem(new MaterialAboutActionItem(getString(R.string.about_libs),null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_github, null), new MaterialAboutActionItem.OnClickListener() {
            @Override
            public void onClick() {
                final Notices notices = new Notices();
                notices.addNotice(new Notice("FastAdapter", "https://github.com/mikepenz/FastAdapter", "Mike Penz", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("CircularReveal", "https://github.com/ozodrukh/CircularReveal", "Abdullaev Ozodrukh", new MITLicense()));
                notices.addNotice(new Notice("MaterialScrollBar", "https://github.com/turing-tech/MaterialScrollBar", "Turing Technologies", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Material About Library", "https://github.com/daniel-stoneuk/material-about-library", "Daniel Stone", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Material Dialogs", "https://github.com/afollestad/material-dialogs", "Aidan Follestad", new MITLicense()));
                notices.addNotice(new Notice("Material Ripple Layout", "https://github.com/balysv/material-ripple", "Balys Valentukevicius", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("ImageBlurring ", "https://github.com/qiujuer/ImageBlurring", "Qiujuer", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("SimpleFingerGestures", "https://github.com/championswimmer/SimpleFingerGestures_Android_Library", "Arnav Gupta", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("TextDrawable", "https://github.com/amulyakhare/TextDrawable", "Amulya Khare", new MITLicense()));
                notices.addNotice(new Notice("AndroidOnboarder", "https://github.com/chyrta/AndroidOnboarder", "Dzmitry Chyrta, Daniel Morales", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("CustomActivityOnCrash", "https://github.com/Ereza/CustomActivityOnCrash", "Eduard Ereza Martínez", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Butter Knife", "https://github.com/JakeWharton/butterknife", "Jake Wharton", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Gson", "url", "Google Inc.", new ApacheSoftwareLicense20()));
                notices.addNotice(new Notice("Android Support Library", "https://developer.android.com/topic/libraries/support-library/revisions.html", "The Android Open Source Project", new ApacheSoftwareLicense20()));
                new LicensesDialog.Builder(AboutActivity.this)
                        .setNotices(notices)
                        .setIncludeOwnLicense(true)
                        .build()
                        .show();
            }
        }));
        titleCard.addItem(ConvenienceBuilder.createRateActionItem(this, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_thumb_up_24dp, null), getString(R.string.about_rate), null));

        MaterialAboutCard.Builder opTeamCard = new MaterialAboutCard.Builder();
        opTeamCard.title(getString(R.string.about_team));

        opTeamCard.addItem(new MaterialAboutActionItem.Builder()
                .icon(R.drawable.person__bennykok)
                .text("BennyKok")
                .subText(getString(R.string.about_credit_text__bennykok))
                .setOnClickListener(ConvenienceBuilder.createWebsiteOnClickAction(this, Uri.parse("http://bennykok.weebly.com/contact.html")))
                .build());
        opTeamCard.addItem(new MaterialAboutActionItem.Builder()
                .icon(R.drawable.person__dkanada)
                .text("dkanada")
                .subText(getString(R.string.about_credit_text__dkanada))
                .setOnClickListener(ConvenienceBuilder.createWebsiteOnClickAction(this, Uri.parse("https://github.com/dkanada")))
                .build());
        opTeamCard.addItem(new MaterialAboutActionItem.Builder()
                .icon(R.drawable.person__gsantner)
                .text("Gregor Santner")
                .subText(getString(R.string.about_credit_text__gsantner))
                .setOnClickListener(ConvenienceBuilder.createWebsiteOnClickAction(this, Uri.parse("https://gsantner.github.io/")))
                .build());
        opTeamCard.addItem(new MaterialAboutActionItem.Builder()
                .icon(R.drawable.person__gaukler_faun)
                .text("Gaukler Faun")
                .subText(getString(R.string.about_credit_text__gaukler_faun))
                .setOnClickListener(ConvenienceBuilder.createWebsiteOnClickAction(this, Uri.parse("https://github.com/scoute-dich")))
                .build());


        MaterialAboutCard.Builder contributorsCard = new MaterialAboutCard.Builder();
        contributorsCard.title(getString(R.string.about_credit));
        contributorsCard.addItem(new MaterialAboutActionItem.Builder()
                .icon(R.drawable.person__chris_debrodie)
                .text("Chris DeBrodie")
                .subText(getString(R.string.about_credit_text__chris_debrodie))
                .setOnClickListener(ConvenienceBuilder.createWebsiteOnClickAction(this, Uri.parse("https://plus.google.com/111923938461696019967")))
                .build());


        //authorCard.addItem(ConvenienceBuilder.createWebsiteActionItem(this, ResourcesCompat.getDrawable(),"Chris DeBrodie",false, Uri.parse("")));

        return new MaterialAboutList.Builder()
                .addCard(titleCard.build())
                .addCard(opTeamCard.build())
                .addCard(contributorsCard.build())
                .build();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.about);
    }
}
