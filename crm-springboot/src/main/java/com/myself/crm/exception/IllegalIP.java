package com.myself.crm.exception;

import org.apache.shiro.authc.AccountException;

/**
 * @Author Gaoxz
 * @CreateTiime 2021-11-24 10:11
 * @apiNote
 */
public class IllegalIP extends AccountException {
    public IllegalIP() {
        super();
    }

    public IllegalIP(String message) {
        super(message);
    }

    public IllegalIP(Throwable cause) {
        super(cause);
    }

    public IllegalIP(String message, Throwable cause) {
        super(message, cause);
    }
}
