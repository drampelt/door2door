package lt.danielrampe.door2door;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import java.io.IOException;

import lt.danielrampe.door2door.authentication.AccountAuthenticator;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @AfterViews
    void init() {
        AccountManager accountManager = AccountManager.get(this);
        Account[] accounts = accountManager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE);
        if (accounts.length > 0) {
            final Account account = accounts[0];
            accountManager.getAuthToken(account, AccountAuthenticator.FULL_TOKEN_TYPE, null, true, new AccountManagerCallback<Bundle>() {
                @Override
                public void run(AccountManagerFuture<Bundle> future) {
                    if (future.isDone() && !future.isCancelled()) {
                        try {
                            Bundle result = future.getResult();
                            String authToken = result.getString(AccountManager.KEY_AUTHTOKEN);
                            Log.d(LOG_TAG, "Got authtoken: " + authToken);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, null);
        }
    }

    @Click(R.id.login_button)
    void login() {
        LoginActivity_.intent(this).start();
    }
}
