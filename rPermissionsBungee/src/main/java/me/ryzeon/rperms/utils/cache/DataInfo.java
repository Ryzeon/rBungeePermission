package me.ryzeon.rperms.utils.cache;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 11:41 p. m.
 */

@Getter
@Setter
public class DataInfo{

    private String name;
    private String prefix;
    private List<String> permission = new ArrayList<>();
}