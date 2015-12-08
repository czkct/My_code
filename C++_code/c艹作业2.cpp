//课本p53(1)
template<class DataType>
void SeqList<DataType>::Reverse(DataType R[], int begin, int end) {
	for(int i = 0; i <(end-begin+1)/2; i++) {
		DataType temp = R[begin+i];
		R[begin+i] = R[end-i];
		R[end-i] = temp;
	}
} 
template<class DataType>
void SegList<DataType>::Converse(DataType R[], int n, int k) {//n元素个数   k移动位置数 
	Reverse(R, 0, k-1);
	Reverse(R, k, n-1);
	Reverse(R, 0, n-1);
}
template<class DataType>
void SeqList<DataType>::move(Datatype A[], int length, int k) {
	Converse(A, length, k); 
}

//课本p53(2)
void Adjust(int A[], int n) {//n是数组元素个数 
	int i = 0, j = n-1;
	while(i < j) {
		while(A[i]%2!=0) i++;
		while(A[j]%2==0) j--;
		if(i < j) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}
}

//p53思考题3
Node* Add(Node* P, Node* Q) {
	Node* p = P;
	Node* q = Q;
	while(p->next!=NULL) p = p->next;
	while(q->next!=NULL) q = q->next;
	while(
}








