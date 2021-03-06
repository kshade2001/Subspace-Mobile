/*  Subspace Mobile - A Android Subspace Client
    Copyright (C) 2012 Kingsley Masters. All Rights Reserved.
    
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

package com.subspace.android;

import android.graphics.Color;

public class LVLTile {
	
	public static final int  TILE_START = 1;
	public static final int  TILE_END = 160;
	
    public static final int  FLAG = 170;
    public static final int  SAFETY = 171;
    public static final int  GOAL = 172;

    //Large objects
    public static final int  WORMHOLE = 220;
    public static final int  STATION = 219;
    public static final int  LARGE_ASTEROID = 217;

    public static final int  SMALL_ASTEROID1 = 216;
    public static final int  SMALL_ASTEROID2 = 218;

    public static final int  FIRST_FLYUNDER = 176;
    public static final int  LAST_FLYUNDER = 190;

    public short X;
    public short Y;
    public short Type;

    public LVLTile(short x, short y, short tiletype)
    {
        X = x;
        Y= y;        
        Type = tiletype;
    }
    
    public int getPixelColor() 
    {
       
            // special objects
            if(Type < 0) return Color.MAGENTA;
            //empty
            if(Type ==0) return Color.BLACK;
            //normal
            if(Type >=1 & Type <=161) return  Color.argb(255,192,192,192);
            //doors
            if(Type >=162 & Type <=169) return Color.BLUE;
            //flag
            if(Type ==FLAG) return Color.YELLOW;
            //safe
            if(Type ==SAFETY) return Color.GREEN;
            //soccer
             if(Type ==GOAL) return Color.RED;
            //flyover
            if(Type >=173 & Type <=175) return Color.CYAN;
            //flyunder  (return normal color dont want to help people :P)
            if (Type >= 176 & Type <= 190) return Color.argb(255,192, 192, 192);
            //
            if(Type >=191 & Type <=215) return Color.MAGENTA;
            //
              if(Type >=216 & Type <=255) return Color.MAGENTA;
            //invalid
            return Color.BLACK;

        
    }
}
