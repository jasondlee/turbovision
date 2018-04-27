/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.steeplesoft.turbovision;

/**
 *
 * @author jdlee
 */
public interface SystemCodes {

    int 
            evMouseDown = 0x0001,
            evMouseUp = 0x0002,
            evMouseMove = 0x0004,
            evMouseAuto = 0x0008,
            evKeyDown = 0x0010,
            evCommand = 0x0100,
            evBroadcast = 0x0200,
            /* Event masks */
            evNothing = 0x0000,
            evMouse = 0x000f,
            evKeyboard = 0x0010,
            evMessage = 0xFF00,
            /* Mouse button state masks */
            mbLeftButton = 0x01,
            mbMiddleButton = 0x02,
            mbRightButton = 0x04,
            mbButton4 = 0x08,
            mbButton5 = 0x10;
}
