/*
 * Copyright (C) 2016 Lartsev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package binary_search;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lartsev
 */
public class BinarySearchByMeTest {
    
    BinarySearchByMe bs;
    long f;
    
    public BinarySearchByMeTest() {
    }
    
    @Before
    public void setUp() {
        long[] a = {9, 18, 27, 36, 45, 54, 63, 72, 81, 90, 99, 108, 117, 126, 135, 144};
        f = 27;
        bs = new BinarySearchByMe(a);
    }
    
    /**
     * Test of find method, of class BinarySearchByMe.
     */
    @Test
    public void testFind() {
        int expResult = bs.find(f);
        int result = 2;
        System.out.println("Find at position " + expResult);
        assertEquals(expResult, result);
    }
    
}
