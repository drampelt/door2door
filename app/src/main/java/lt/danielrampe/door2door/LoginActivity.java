package lt.danielrampe.door2door;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import lt.danielrampe.door2door.authentication.AccountAuthenticator;

/**
 * Created by Daniel on 2015-06-25.
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends AccountAuthenticatorActivity {
    private static final String LOG_TAG = LoginActivity.class.getSimpleName();

    @Extra
    String accountType;
    @Extra
    String authType;
    @Extra
    boolean isAddingNewAccount;
    @Extra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE)
    AccountAuthenticatorResponse accountAuthenticatorResponse;

    @ViewById(R.id.email)
    TextView mEmail;
    @ViewById(R.id.password)
    TextView mPassword;

    @Click(R.id.login_button)
    void login() {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        Log.d(LOG_TAG, "Email:" + email + ", pass:" + password);

        AccountManager accountManager = AccountManager.get(this);

        final Account account = new Account(email, AccountAuthenticator.ACCOUNT_TYPE);
        accountManager.addAccountExplicitly(account, null, null);
        accountManager.setAuthToken(account, AccountAuthenticator.FULL_TOKEN_TYPE, "ayy lmao");

        final Intent intent = new Intent();
        intent.putExtra(AccountManager.KEY_ACCOUNT_NAME, email);
        intent.putExtra(AccountManager.KEY_ACCOUNT_TYPE, AccountAuthenticator.ACCOUNT_TYPE);
        intent.putExtra(AccountManager.KEY_AUTHTOKEN, "ayy lmao");
        this.setAccountAuthenticatorResult(intent.getExtras());
        this.setResult(RESULT_OK, intent);
        this.finish();
    }

    @Click(R.id.cancel_button)
    void cancel() {
        finish();
    }
}
