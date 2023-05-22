package xyz.srnyx.annoyingapi.reflection.org.bukkit;

import org.bukkit.plugin.Plugin;

import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.utility.ReflectionUtility;

import java.lang.reflect.Constructor;


/**
 * org.bukkit.NamespacedKey
 */
public class NamespacedKey {
    /**
     * 1.12+ org.bukkit.NamespacedKey
     */
    @Nullable public static final Class<?> NAMESPACED_KEY_CLASS = ReflectionUtility.getClass(10120, "org.bukkit.NamespacedKey");

    /**
     * 1.12+ org.bukkit.NamespacedKey#constructor(org.bukkit.plugin.Plugin, String)
     */
    @Nullable public static final Constructor<?> NAMESPACED_KEY_CONSTRUCTOR = ReflectionUtility.getConstructor(10120, NAMESPACED_KEY_CLASS, Plugin.class, String.class);

    /**
     * This class cannot be instantiated
     *
     * @throws  UnsupportedOperationException   if this class is instantiated
     */
    private NamespacedKey() {
        throw new UnsupportedOperationException("This is a reflected class and cannot be instantiated");
    }
}
