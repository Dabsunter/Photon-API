/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon API <https://github.com/mcphoton/Photon-API>.
 *
 * The Photon API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.plugin;

import com.electronwill.utils.Constant;
import java.io.File;
import org.mcphoton.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A WorldPlugin is associated with a game world, and isn't aware of what happens in the other worlds.
 *
 * @author TheElectronWill
 */
public abstract class WorldPlugin implements Plugin {

	protected final Logger logger = LoggerFactory.getLogger(getName());
	private final Constant<File> directory = new Constant<>();
	private final Constant<File> configFile = new Constant<>();
	private final Constant<PluginLoader> loader = new Constant<>();
	private final Constant<World> world = new Constant<>();

	@Override
	public final File getDirectory() {
		return directory.get();
	}

	@Override
	public final File getConfigFile() {
		return configFile.get();
	}

	@Override
	public final Logger getLogger() {
		return logger;
	}

	/**
	 * Gets the world where this plugin is loaded.
	 */
	public final World getActiveWorld() {
		return world.get();
	}

	public final void init(PluginLoader loader, World world) {
		this.loader.init(loader);
		this.world.init(world);

		File directory = new File(world.getDirectory(), getName());
		this.directory.init(directory);
		this.configFile.init(new File(directory, "config.toml"));
	}

}
