package cn.yj.dominate.model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by yangjie on 2017/6/19.
 */

public class ConfigModel extends RealmObject implements Serializable {
    private boolean isShowSystemApps;

    public boolean isShowSystemApps() {
        return isShowSystemApps;
    }

    public void setShowSystemApps(boolean showSystemApps) {
        isShowSystemApps = showSystemApps;
    }
}
