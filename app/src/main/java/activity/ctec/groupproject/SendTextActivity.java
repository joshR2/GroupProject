package activity.ctec.groupproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.app.Activity;
import android.widget.Toast;
import android.telephony.SmsManager;


public class SendTextActivity extends Activity
{
    private Button sendButton;
    private EditText phoneNumber;
    private EditText messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        sendButton = (Button) findViewById(R.id.sendButton);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        messageText = (EditText) findViewById(R.id.messageText);

        setupListeners();
    }
    private void setupListeners()
    {
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View currentView) {
                try {
                    String contact = phoneNumber.getText().toString();
                    String message = messageText.getText().toString();
                    sendSMS(contact, message);

                    Toast.makeText(currentView.getContext(), "message was sent" , Toast.LENGTH_SHORT).show();
                } catch (Exception currentException) {
                    Toast.makeText(currentView.getContext(), "message was not sent" , Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    /**
     * Sends a Text based SMS to a specified number.
     * @param messageAddress the number this app sends a text to.
     *@param messageContent The message being sent.
     */
    private void sendSMS(String messageAddress, String messageContent)
    {
        SmsManager mySMSManager = SmsManager.getDefault();
        mySMSManager.sendTextMessage(messageAddress, null, messageContent,null,null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}

