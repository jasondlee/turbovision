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

#if !defined( __TStatusDef )
#define __TStatusDef
class  TStatusItem;

class CLY_EXPORT TStatusDef
{

public:

    TStatusDef( ushort aMin,
                ushort aMax,
                TStatusItem *someItems = 0,
                TStatusDef *aNext = 0
              );
    TStatusDef& addItem ( TStatusItem& s2 );
            
    TStatusDef *next;
    ushort min;
    ushort max;
    TStatusItem *items;
};

inline TStatusDef::TStatusDef( ushort aMin,
                               ushort aMax,
                               TStatusItem *someItems,
                               TStatusDef *aNext
                             ) :
    next( aNext ), min( aMin ), max( aMax ), items( someItems )
{
}

#endif  // Uses_TStatusDef

