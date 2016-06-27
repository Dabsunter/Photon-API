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
package org.mcphoton;

import java.io.File;
import org.mcphoton.block.BlockRegistry;
import org.mcphoton.entity.EntityRegistry;
import org.mcphoton.item.ItemRegistry;
import org.mcphoton.network.PacketsManager;
import org.mcphoton.permissions.PermissionsManager;
import org.mcphoton.server.Server;
import org.mcphoton.world.BiomeRegistry;

/**
 * The centralized API core. Gives access to many core points of the API, like the {@link PermissionsManager}.
 *
 * @author TheElectronWill
 * @author Maaattt
 */
public final class Photon {

	private Photon() {
	}

	public static PacketsManager getPacketsManager() {
		return null;
	}

	public static PermissionsManager getPermissionsManager() {
		return null;
	}

	public static EntityRegistry getEntityRegistry() {
		return null;
	}

	public static BlockRegistry getBlockRegistry() {
		return null;
	}

	public static ItemRegistry getItemRegistry() {
		return null;
	}

	public static BiomeRegistry getBiomeRegistry() {
		return null;
	}

	public static boolean isClient() {
		return false;
	}

	public static boolean isServer() {
		return false;
	}

	public static boolean isConsoleAdvanced() {
		return false;
	}

	public static String getVersion() {
		return "dev-alpha";
	}

	public static String getMinecraftVersion() {
		return "1.10";
	}

	public static File getMainDirectory() {
		return null;
	}

	public static File getPluginsDirectory() {
		return null;
	}

	public static Server getServer() {
		return null;
	}

}
