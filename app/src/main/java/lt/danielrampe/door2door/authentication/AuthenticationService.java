package lt.danielrampe.door2door.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Daniel on 2015-06-26.
 */
public class AuthenticationService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new AccountAuthenticator(this).getIBinder();
    }

}
