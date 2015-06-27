package lt.danielrampe.door2door.sync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Daniel on 2015-06-26.
 */
public class Door2DoorSyncAdapter extends AbstractThreadedSyncAdapter {
    private final AccountManager mAccountManager;

    public Door2DoorSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        mAccountManager = AccountManager.get(context);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        Log.d("Door2DoorSync", "Starting sync for account " + account.name);
    }
}
