package com.cache.api.deledgate;

import com.cache.api.dto.LoginInfo;
import com.cache.api.dto.ReqLogin;
import com.cache.api.utils.CommonHttpResult;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserDeledgate {
    private static String TAG = "UserDeledgate";

    // 建立 Guava Cache 儲存 LoginInfo
    private static final Cache<String, LoginInfo> loginTokens = CacheBuilder.newBuilder()
            .maximumSize(10000) // Cache 最大容量
            .expireAfterAccess(10, TimeUnit.SECONDS) // 5 秒內被訪問就會重置過期時間 (可以一直續命)
            // .expireAfterWrite(10, TimeUnit.SECONDS) // 只要寫入 Cache 後，過期時間開始計算，5 秒後移除（簡單來說只活 5 秒)
            .build();

    public static CommonHttpResult<LoginInfo> login(ReqLogin reqLogin) {

        LoginInfo loginInfo = null;

        // 驗證帳號密碼，並且產生一組 token
        String token = generateRandomToken(reqLogin.getAcc(), reqLogin.getPwd());
        loginInfo = new LoginInfo(token, reqLogin.getAcc());

        // 將 loginInfo 資訊存入 Cache
        loginTokens.put(token, loginInfo);

        return new CommonHttpResult<LoginInfo>(0, loginInfo);
    }

    public static CommonHttpResult<String> getUserAccount(String token) {

        String account = null;
        int resultId = 0;

        // 判斷 Cache 中 token 是否存在，不存在表示失效
        LoginInfo loginInfo = loginTokens.asMap().get(token);

        if (loginInfo == null) {
            resultId = 1;
        } else {
            account = loginInfo.getAccount();
        }
        return new CommonHttpResult<String>(resultId, account);
    }

    private static String generateRandomToken(String acc, String pwd) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder tokenBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(chars.length());
            tokenBuilder.append(chars.charAt(index));
        }
        return tokenBuilder.toString();
    }

    public static CommonHttpResult<Map<String, LoginInfo>> printAllLoginTokens() {
        return new CommonHttpResult<>(0, loginTokens.asMap());
    }

}
