/*
SubspaceMobile - A subspace/continuum client for mobile phones
Copyright (C) 2010 Kingsley Masters
Email: kshade2001 at users.sourceforge.net

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


REVISIONS:
 */

package com.subspace.network.messages;

import java.nio.ByteBuffer;

	/*
		0x0A	Password Packet Response

		Offset	Length	Description
		0		1		Type Byte 0x0A
		1		1		Login Response *1
		2		4		Server Version *2
		6		4		? Unknown
		10		4		Subspace.exe Checksum *3
		14		4		? Unknown
		18		1		? Unknown
		19		1		Registration Form Request (Boolean)
		20		4		? Unknown
		24		4		News.txt Checksum *4
		28		8		? Unknown


		*1  -  The following is a list of what all the differnt Response
				codes mean.

				0x00 - Login OK
				0x01 - Unregistered Player *a1
				0x02 - Bad Password
				0x03 - Arena is Full
				0x04 - Locked Out of Zone
				0x05 - Permission Only Arena
				0x06 - Permission to Spectate Only
				0x07 - Too many points to Play here
				0x08 - Connection is too Slow
				0x09 - Permission Only Arena
				0x0A - Server is Full
				0x0B - Invalid Name
				0x0C - Offensive Name
				0x0D - No Active Biller *a2
				0x0E - Server Busy, try Later
				0x10 - Restricted Zone *a3
				0x11 - Demo Version Detected
				0x12 - Too many Demo users
				0x13 - Demo Versions not Allowed
				0xFF - Restricted Zone, Mod Access Required

				*a1 - Some Billers requir you to register and will
					kick you out after a short time if you do not
					send the Registration form.

				*a2 - You can still log in, but scores are not being
					perminently recorded.

				*a3 - This restriction is usualy based on insuficient
					hours of Usage.

		*2  - Returns the Major and the Minor version as a signle number
			(so 1.34.12a returns 134) does not return Sub Version..

		*3  - Compare against local Subspace.exe to determine if an Update
			is neaded. (obviously useless with a bot)

		*4  - Compare against local News.txt to determine if there is a new
			News.txt to be downloaded.
	*/



public class LoginResponse {
	
	
    public final byte ResponseCode;
    public final LoginResponseCode Response;
    public final int ServerVersion;
    public final int EXEChecksum;
    public final boolean RegistrationFormRequest;
    public final int NewsChecksum;
    
    
    public LoginResponse(byte code, int version, int exe, boolean regForm, int news)
    {
        ResponseCode = code;
        Response = LoginResponseCode.fromCode(ResponseCode);
        ServerVersion = version;
        EXEChecksum = exe;
        RegistrationFormRequest = regForm;
        NewsChecksum = news;
    }
    
    public LoginResponse(ByteBuffer buffer)
    {
    	ResponseCode = buffer.get(1);
    	Response = LoginResponseCode.fromCode(ResponseCode);
    	ServerVersion = buffer.getInt(2);
    	EXEChecksum = buffer.getInt(10);
    	RegistrationFormRequest = (boolean)(buffer.get(19) != 0);
    	NewsChecksum = buffer.getInt(24);
    	
    }
    
    public boolean isLoginOK()
    {
    	return 0x00 == ResponseCode;
    }
    
    public String getLoginMessage()
    {
    	switch(ResponseCode)
    	{
    	case 0x00: return "Login OK";
    	case 0x01: return "Unregistered Player";
    	case 0x02: return "Bad Password";
    	case 0x03: return "Arena is Full";
    	case 0x04: return "Locked Out of Zone";
    	case 0x05: return "Permission Only Arena";
    	case 0x06: return "Permission to Spectate Only";
    	case 0x07: return "Too many points to Play here";
    	case 0x08: return "Connection is too Slow";
    	case 0x09: return "Permission Only Arena";
    	case 0x0A: return "Server is Full";
    	case 0x0B: return "Invalid Name";
    	case 0x0C: return "Offensive Name";
    	case 0x0D: return "No Active Biller";
    	case 0x0E: return "Server Busy, try Later";
    	case 0x10: return "Restricted Zone";
    	case 0x11: return "Demo Version Detected";
    	case 0x12: return "Too many Demo users";
    	case 0x13: return "Demo Versions not Allowed";
    	case (byte)0xFF: return "Restricted Zone, Mod Access Required";
    	default: return "Unknown";
    	
    	}
    }
    
}
