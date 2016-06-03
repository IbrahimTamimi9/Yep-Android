/*
 * 				Twidere - Twitter client for Android
 * 
 *  Copyright (C) 2012-2014 Mariotaku Lee <mariotaku.lee@gmail.com>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package catchla.yep.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentAccessor
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

abstract class SupportFixedFragmentStatePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun instantiateItem(container: ViewGroup, position: Int): Any? {
        val f = super.instantiateItem(container, position) as Fragment?
        val savedFragmentState = if (f != null) FragmentAccessor.getSavedFragmentState(f) else null
        if (savedFragmentState != null && f != null) {
            savedFragmentState.classLoader = f.javaClass.classLoader
        }
        return f
    }

}
