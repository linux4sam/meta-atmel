/*
  This file is part of PLplot.
  
  PLplot is free software; you can redistribute it and/or modify
  it under the terms of the GNU Library General Public License as published
  by the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.
  
  PLplot is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU Library General Public License for more details.
  
  You should have received a copy of the GNU Library General Public License
  along with PLplot; if not, write to the Free Software
  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
  
  
  This header file contains the table containing the linear transforms 
  for converting between TAI and UTC.
  It is an automatically generated file, so please do
  not edit it directly. Make any changes to tai-utc.dat then use
  tai-utc-gen to recreate this header file.
  
  tai-utc.dat contains four essential fields to represent the following
  formula for the linear transformation between TAI and UTC: 
    TAI-UTC (seconds) = offset1 + (MJD-offset2)*slope
  There are four essential fields per line in tai-utc.dat to represent
  this formula.  They are the Julian date (UTC) where the linear
  transformation implied by the line is first applied;
  offset1 (seconds); offset2 (days), and slope (secs/day).
  
*/
typedef struct {
	int base_day;
	double time_sec_tai;
	double time_sec_utc;
	double size_prev_leap_sec;
	double offset1;
	int offset2;
	double slope;
} TAI_UTC;

const int number_of_entries_in_tai_utc_table=38;

const TAI_UTC TAI_UTC_lookup_table[38] = {
{37300,      1.42281800, 0.,     0.00000000000000,      1.42281800, 37300,      0.00129600},
{37512,      1.64757000, 0.,    -0.04999999925000,      1.37281800, 37300,      0.00129600},
{37665,      1.84585800, 0.,     0.00000000000000,      1.84585800, 37665,      0.00112320},
{38334,      2.69727880, 0.,     0.09999999870000,      1.94585800, 37665,      0.00112320},
{38395,      2.76579400, 0.,     0.00000000000000,      3.24013000, 38761,      0.00129600},
{38486,      2.98373000, 0.,     0.09999999850000,      3.34013000, 38761,      0.00129600},
{38639,      3.28201800, 0.,     0.09999999850000,      3.44013000, 38761,      0.00129600},
{38761,      3.54013000, 0.,     0.09999999850000,      3.54013000, 38761,      0.00129600},
{38820,      3.71659400, 0.,     0.09999999850000,      3.64013000, 38761,      0.00129600},
{38942,      3.97470600, 0.,     0.09999999850000,      3.74013000, 38761,      0.00129600},
{39004,      4.15505800, 0.,     0.09999999850000,      3.84013000, 38761,      0.00129600},
{39126,      4.31317000, 0.,     0.00000000000000,      4.31317000, 39126,      0.00259200},
{39887,      6.18568200, 0.,    -0.09999999699999,      4.21317000, 39126,      0.00259200},
{41317,     10.00000000, 0.,     0.10775799676726,     10.00000000, 41317,      0.00000000},
{41499,     11.00000000, 0.,     1.00000000000000,     11.00000000, 41317,      0.00000000},
{41683,     12.00000000, 0.,     1.00000000000000,     12.00000000, 41317,      0.00000000},
{42048,     13.00000000, 0.,     1.00000000000000,     13.00000000, 41317,      0.00000000},
{42413,     14.00000000, 0.,     1.00000000000000,     14.00000000, 41317,      0.00000000},
{42778,     15.00000000, 0.,     1.00000000000000,     15.00000000, 41317,      0.00000000},
{43144,     16.00000000, 0.,     1.00000000000000,     16.00000000, 41317,      0.00000000},
{43509,     17.00000000, 0.,     1.00000000000000,     17.00000000, 41317,      0.00000000},
{43874,     18.00000000, 0.,     1.00000000000000,     18.00000000, 41317,      0.00000000},
{44239,     19.00000000, 0.,     1.00000000000000,     19.00000000, 41317,      0.00000000},
{44786,     20.00000000, 0.,     1.00000000000000,     20.00000000, 41317,      0.00000000},
{45151,     21.00000000, 0.,     1.00000000000000,     21.00000000, 41317,      0.00000000},
{45516,     22.00000000, 0.,     1.00000000000000,     22.00000000, 41317,      0.00000000},
{46247,     23.00000000, 0.,     1.00000000000000,     23.00000000, 41317,      0.00000000},
{47161,     24.00000000, 0.,     1.00000000000000,     24.00000000, 41317,      0.00000000},
{47892,     25.00000000, 0.,     1.00000000000000,     25.00000000, 41317,      0.00000000},
{48257,     26.00000000, 0.,     1.00000000000000,     26.00000000, 41317,      0.00000000},
{48804,     27.00000000, 0.,     1.00000000000000,     27.00000000, 41317,      0.00000000},
{49169,     28.00000000, 0.,     1.00000000000000,     28.00000000, 41317,      0.00000000},
{49534,     29.00000000, 0.,     1.00000000000000,     29.00000000, 41317,      0.00000000},
{50083,     30.00000000, 0.,     1.00000000000000,     30.00000000, 41317,      0.00000000},
{50630,     31.00000000, 0.,     1.00000000000000,     31.00000000, 41317,      0.00000000},
{51179,     32.00000000, 0.,     1.00000000000000,     32.00000000, 41317,      0.00000000},
{53736,     33.00000000, 0.,     1.00000000000000,     33.00000000, 41317,      0.00000000},
{54832,     34.00000000, 0.,     1.00000000000000,     34.00000000, 41317,      0.00000000},
};
