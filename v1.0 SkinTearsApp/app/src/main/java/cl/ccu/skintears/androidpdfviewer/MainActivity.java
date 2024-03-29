package cl.ccu.skintears.androidpdfviewer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cl.ccu.skintears.R;
import com.pdftron.pdf.controls.DocumentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer_btn);

        Button openWithAndroid = findViewById(R.id.open_pdf_android);
        openWithAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfWithAndroidSDK();
            }
        });

        Button openWithPDFTron = findViewById(R.id.open_pdf_pdftron1);
        openWithPDFTron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfWithPDFTron();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    void openPdfWithAndroidSDK() {
        Intent intent = new Intent(this, AndroidPDFViewer.class);
        startActivity(intent);
    }

    void openPdfWithPDFTron() {
        DocumentActivity.openDocument(this, R.raw.guideline);
    }
}
