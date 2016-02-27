/**
* Test Data 
*
* @author  Jian Huang
* @since   2015-07-06
*/

package jian.huang.exinda.utility;

public class TestData {
	
	public static final String[] valid_ipv4_test_data = {
		"192.168.1.2", 
		"0.0.0.0",
		"255.255.255.255",
		};
	
	public static final String[] invalid_ipv4_test_data = {
		"266.233.156.255",
		"125.15.15.0 0",
		"125.15.15.00.78",
		"231.123.154",
		"123.167",
		"2",
		"12",
		"126",
		"1265",
		};
	
	public static final String[] valid_ipv6_test_data = {
		"fe80:aa67:fcd6:aa23:b4b2:a8ff:fee6:ffa7",
		"Fe99::9",
		"::"
		};
	
	public static final String[] invalid_ipv6_test_data = {
		"fe80:aa67:fcd6:aa23:b4b2:a8ff:fee6:ffa70", 
		"fe80:aa67:fcd6:aa23:b4b2:a8ff:fee6:ff a7",
		"aa67:d6:a25:b462:aeff:feb6:fffa",
		"fe80:aa67:fcd6:aa23:b4b2:a8ff:fee6:ffa7:dd3",
		"a",
		"1A",
		"16B",
		"165a",
		"fe80:aa67:fcd6:aa23:b4b2:a8ff:fee6::ffa7",
		"fe80:aa67::aa23:b4b2::fee6:ffa7",
		"we9:aa67:fcd6:aa23:b4b2:a8ff:fee6:Fa7",
		};
	
}
