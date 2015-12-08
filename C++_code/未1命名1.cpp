//ѭ������-------------------------------------------- 

//����Ԫ�� 
template <class DataType>
void LinkList<DataType>::Insert(int i, DataType x) {
	p = first->next;
	int count = 0;
	while(p != NULL && count < i-1) {
		p = p->next;
		count++;	
	}
	if(p == NULL) throw "λ��"; 
	else {
		s = new Node; s->data = x;
		s->next = p->next; p->next = s; 
	}
} 
//ɾ��Ԫ��  ���ҷ���ɾ����ֵ 
template <class DataType>
DataType LinkList<DataType>::Delete(int i) {
	p = first->next;
	int count = 0;
	while(p != NULL && count <i-1) {
		p = p->next;
		count++;
	}
	if(p == NULL) throw "λ��";
	else {
		q = p->next; x = q->data;
		p ->next = q->next;
		delete q;
		return x;
	}
}

//˫����------------------------------------------- 
//�������
template <class DataType>
void LinkList<DataType>::Insert(int i, DataType x) {
	p = first->next;
	int count = 0;
	while(p != NULL && count < i-1) {
		p = p->next;
		count++;	
	}
	//��p�����ڵ� 
	if(p == NULL) throw "λ��"; 
	else {
		s = new Node; s->data = x;
		s->prior = p;
		s->next = p->next;
		p->next->prior = s;
		p->next = s;
	}
} 
//ɾ������ 
template <class DataType>
void LinkList<DataType>::Delete(int i) {
	p = first->next;
	int count = 0;
	while(p != NULL && count < i) {
		p = p->next;
		count++;	
	}
	//ʹpָ���ɾ�ڵ� 
	if(p == NULL) throw "λ��"; 
	else {
		q = p;
		p->prior->next = p->next;
		p->next->prior = p->prior;
		delete q;
	}
} 
