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
package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPL4Y
 */
public class EffectPacket implements Packet {

	public int effectId, data;
	public int x, y, z;
	public boolean disableRelativeVolume;

	@Override
	public int getId() {
		return 0x21;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeInt(effectId);
		out.writeLong(ProtocolHelper.encodePosition(x, y, z));
		if (effectId == 1010 || (2000 <= effectId && effectId <= 2002) || effectId == 2005) {
			out.writeInt(data);
		}
		out.writeBoolean(disableRelativeVolume);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		effectId = buff.getInt();
		x = ProtocolHelper.decodePositionX(buff.getLong());
		y = ProtocolHelper.decodePositionY(buff.getLong());
		z = ProtocolHelper.decodePositionZ(buff.getLong());
		if (effectId == 1010 || (2000 <= effectId && effectId <= 2002) || effectId == 2005) {
			data = buff.getInt();
		}
		disableRelativeVolume = ProtocolHelper.readBoolean(buff);
		return this;
	}

	@Override
	public String toString() {
		return "EffectPacket{" + "effectId=" + effectId + ", x=" + x + ", y=" + y + ", z=" + z + ", data=" + data + ", disableRelativeVolume=" + disableRelativeVolume + '}';
	}

}
