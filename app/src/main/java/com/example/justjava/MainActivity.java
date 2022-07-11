/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int numberOfCofees = 2;

    public void decreament(View view) {
        numberOfCofees--;
        if(numberOfCofees<0)
            numberOfCofees = 0;
        display(numberOfCofees);
    }

    public void increament(View view) {
        numberOfCofees++;
        if(numberOfCofees>100)
            numberOfCofees =100;
        display(numberOfCofees);
    }

    public void submitOrder(View view) {
        String name = "Kannu";
        String message = "Item count $ " + numberOfCofees * 5;
        CheckBox Checked = (CheckBox) findViewById(R.id.checkbox);
        boolean hasChecked = Checked.isChecked();
        CheckBox chocoChecked = (CheckBox) findViewById(R.id.checkbox2);
        boolean haschocoChecked = chocoChecked.isChecked();
        EditText textname = (EditText) findViewById(R.id.Name_view);
        String name1 = textname.getText().toString();
        displayMessage(CreateSummaryM(numberOfCofees, hasChecked, haschocoChecked, name1));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        quantityTextView.setText("" + number);
    }


    private String CreateSummaryM(int numberOfCofees, boolean haschecked, boolean choco, String name1) {
        int tprice = numberOfCofees * 5;
        if (haschecked) {
            tprice += numberOfCofees * 2;
        }
        if(choco){
            tprice += numberOfCofees * 1;
        }
        String pricemessage = "Name = " + name1;
        pricemessage += "\n" + "Item count $ " + tprice;
        pricemessage += "\nIs the cream is wiped " + haschecked;
        if (choco)
            pricemessage += "\nU need chocolate";
        pricemessage += "\nQuantity " + numberOfCofees;
        pricemessage += "\nThank You";
        return pricemessage;

    }
}

