/*  Subspace Mobile - A Android Subspace Client
    Copyright (C) 2013 Kingsley Masters. All Rights Reserved.
    
    kingsley dot masters at gmail dot com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.subspace.network.messages;

import java.nio.ByteBuffer;

public class PlayerLeave {
	public final short Id;
	
	public PlayerLeave(ByteBuffer bb)
	{
		Id = bb.getShort(1);
	}
}