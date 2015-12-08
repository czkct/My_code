int lower_bound(char* A, int x, int y, int v){//���ֲ������½� ����ͬ�������ǰ��һ���� 
	int m;
	while(x < y) {
		m = x+(y-x)/2;
		if(A[m]>=v) y = m;
		else x = m+1;
	}
	return x;
} //���ܲ�������������ҿ��ڼ�[x,y)������ֵ�ĺ�ѡ��ȴ�Ǳ�����[x, y]�� 

int upper_bound(char* A, int x, int y, int v){//���ֲ������Ͻ� ����ͬ����������һ���� 
	int m;
	while(x < y) {
		m = x+(y-x)/2;
		if(A[m]<=v) x = m+1;
		else y = m;
	}
	return x;
} 
//��v����ʱ�����������ֵ����һ��λ�õĺ���һ��λ�á���v�������򷵻�һ�������±� 

int bsearch(int* A, int x, int y, int v){  //���ֲ����Ƿ����vֵ 
	int m;
	while(x<y){
		m = x+(y-x)/2;
		if(A[m]==v) return m;
		else if(A[m]>v) y = m;
		else x = m+1;
	}
	return -1
} 

