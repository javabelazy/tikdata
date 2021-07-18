# tikdata
tikdata coding test
Attached is a file(input.txt) with data known as ‘tickData’. This file consists of several columns. For this question we will consider only "STOCK","LTP","TIME" columns. Rest columns and values
can be ignored.
There are two task you need to perform :

TASK 1 : Convert tickData file in OHLC File :

tick data is the price of the particular stock at any given time. you need to group the data for each stock for each minute and find its Open (first price in that minute) ,
High (highest price in that minute), Low (lowest price in that minute), close(last price of that minute) for that minute. This is called OHLC (open/high/low/close) data.

In a minute we can receive the price of the stocks for upto 100 times.(Not fixed)
e.g.

"STOCK" "LTP" "TIME"
"NQ" 6972.75 08.11.51.319 AM
"NQ" 6974.25 08.12.12.761 AM
"NQ" 6975.25 08.12.42.728 AM
"NQ" 6973.75 08.13.12.700 AM
"NQ" 6974.25 08.13.42.768 AM


For given input above, Output will be

STOCK Open High Low Close TIME
NQ 6972.75 6972.75 6972.75 6972.75 01-NOV-18 08.11.00.00 AM
NQ 6974.25 6975.25 6974.25 6975.25 01-NOV-18 08.12.00.00 AM
NQ 6973.75 6974.25 6973.75 6974.25 01-NOV-18 08.13.00.00 AM

Basically take all prices for the stock in a particular minute, Find its open, high, low, close and print it along with a time and stock name (tab separated).

TASK 2 :

Now since you have OHLC data with you from step 1, you need to calculate the zScore for the stocks. please follow the steps given below to find the zScore of the stocks at a given minute.

1. At any given minute, take the last 20 close prices for that stock. e.g. If we're calculating zScore for 08:20:00 AM , we will take all close prices for the stock from 08:00:00 to 08:19:00.
2. Since we have a list of the last 20 close prices, we will calculate average and standard deviation of the close prices.
3. Now we have average and standard deviation of last 20 prices and current minutes data as well. so zScore = (current_close - average)/standard_deviation;

e.g.
Consider from Task 1 you got the following OHLC data. (This is sample Data only for explanation and not actual data)

Stock open high low close time
NQ 100 100.2 99 100.2 01-NOV-18 09.10.00.00 AM
NQ 100 101.2 99 101.2 01-NOV-18 09.11.00.00 AM
NQ 100 100.2 99 99 01-NOV-18 09.12.00.00 AM
NQ 100 100.2 99 100 01-NOV-18 09.13.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.14.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.15.00.00 AM
NQ 100 100.2 99 100 01-NOV-18 09.16.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.17.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.18.00.00 AM
NQ 100 103 99 103 01-NOV-18 09.19.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.20.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.21.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.22.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.23.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.24.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.25.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.26.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.27.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.28.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.29.00.00 AM
NQ 100 100.2 99 100.2 01-NOV-18 09.30.00.00 AM

Now if we wish to calculate zScore at 01-NOV-18 09.30.00.00 AM, We will take previous 20 close prices i.e. From 01-NOV-18 09.10.00.00 AM to 01-NOV-18 09.29.00.00 AM.
Calculate average of the prices and standard_deviation for the same.
average = 100.31
standard_deviation = 0.72974
zScore  = (100.2-100.31)/0.72974 = -1.5073


Output should be:

Stock zScore time
NQ -1.5073 01-NOV-18 09.30.00.00 AM
and so on.
