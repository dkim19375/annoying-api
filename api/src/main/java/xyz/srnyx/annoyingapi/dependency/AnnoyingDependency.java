package xyz.srnyx.annoyingapi.dependency;

import org.bukkit.Bukkit;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.PluginPlatform;

import java.io.File;
import java.util.Set;


/**
 * Represents a downloadable dependency
 */
public class AnnoyingDependency {
    /**
     * The name of the dependency (from it's {@code plugin.yml})
     */
    @NotNull public final String name;
    /**
     * The platforms the dependency can be downloaded from
     */
    @NotNull public final PluginPlatform.Multi platforms;
    /**
     * Whether the dependency is required to be installed. If the download fails and this is true, the plugin will not enable
     * <p><i>This does <b>NOT</b> stop the dependency from being downloaded/installed</i>
     */
    public final boolean required;
    /**
     * Whether to attempt to enable the dependency after it has been downloaded
     */
    public final boolean enableAfterDownload;
    /**
     * The new file of the dependency ({@link #name}{@code .jar})
     */
    @NotNull public final File file;

    /**
     * Creates a new dependency instance
     *
     * @param   name                    {@link #name}
     * @param   platforms               {@link #platforms}
     * @param   required                {@link #required}
     * @param   enableAfterDownload     {@link #enableAfterDownload}
     */
    public AnnoyingDependency(@NotNull String name, @NotNull Set<PluginPlatform> platforms, boolean required, boolean enableAfterDownload) {
        this.name = name;
        this.platforms = new PluginPlatform.Multi(platforms);
        this.required = required;
        this.enableAfterDownload = enableAfterDownload;
        this.file = new File(Bukkit.getUpdateFolderFile().getParentFile(), name + ".jar");
    }

    /**
     * This uses {@link Bukkit#getPluginManager()} to check if the dependency isn't installed. So it's vital that {@link #name} is from the plugin's {@code plugin.yml}
     *
     * @return  whether the dependency isn't currently installed
     */
    public boolean isNotInstalled() {
        return Bukkit.getPluginManager().getPlugin(name) == null;
    }
}
