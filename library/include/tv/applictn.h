/*
 *      Turbo Vision - Version 2.0
 *
 *      Copyright (c) 1994 by Borland International
 *      All Rights Reserved.
 *

Modified by Robert Hoehne to be used for RHIDE.

 *
 *
 */

#if !defined( __TApplication )
#define __TApplication

class TApplication : public TProgram
{
public:
    TApplication();

    virtual void suspend();
    virtual void resume();


protected:
    virtual ~TApplication();

};

#endif

