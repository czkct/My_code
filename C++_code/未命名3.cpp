int lower_bound(char* A, int x, int y, int v){//二分查找求下界 （相同多个的最前面一个） 
	int m;
	while(x < y) {
		m = x+(y-x)/2;
		if(A[m]>=v) y = m;
		else x = m+1;
	}
	return x;
} //尽管查找区间是左闭右开期间[x,y)，返回值的候选区却是闭区间[x, y]； 

int upper_bound(char* A, int x, int y, int v){//二分查找求上界 （相同多个的最后面一个） 
	int m;
	while(x < y) {
		m = x+(y-x)/2;
		if(A[m]<=v) x = m+1;
		else y = m;
	}
	return x;
} 
//当v存在时，返回它出现的最后一个位置的后面一个位置。若v不存在则返回一个插入下标 

int bsearch(int* A, int x, int y, int v){  //二分查找是否存在v值 
	int m;
	while(x<y){
		m = x+(y-x)/2;
		if(A[m]==v) return m;
		else if(A[m]>v) y = m;
		else x = m+1;
	}
	return -1
} 

