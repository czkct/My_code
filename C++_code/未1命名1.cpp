//循环链表-------------------------------------------- 

//插入元素 
template <class DataType>
void LinkList<DataType>::Insert(int i, DataType x) {
	p = first->next;
	int count = 0;
	while(p != NULL && count < i-1) {
		p = p->next;
		count++;	
	}
	if(p == NULL) throw "位置"; 
	else {
		s = new Node; s->data = x;
		s->next = p->next; p->next = s; 
	}
} 
//删除元素  并且返回删除的值 
template <class DataType>
DataType LinkList<DataType>::Delete(int i) {
	p = first->next;
	int count = 0;
	while(p != NULL && count <i-1) {
		p = p->next;
		count++;
	}
	if(p == NULL) throw "位置";
	else {
		q = p->next; x = q->data;
		p ->next = q->next;
		delete q;
		return x;
	}
}

//双链表------------------------------------------- 
//插入操作
template <class DataType>
void LinkList<DataType>::Insert(int i, DataType x) {
	p = first->next;
	int count = 0;
	while(p != NULL && count < i-1) {
		p = p->next;
		count++;	
	}
	//在p后插入节点 
	if(p == NULL) throw "位置"; 
	else {
		s = new Node; s->data = x;
		s->prior = p;
		s->next = p->next;
		p->next->prior = s;
		p->next = s;
	}
} 
//删除操作 
template <class DataType>
void LinkList<DataType>::Delete(int i) {
	p = first->next;
	int count = 0;
	while(p != NULL && count < i) {
		p = p->next;
		count++;	
	}
	//使p指向待删节点 
	if(p == NULL) throw "位置"; 
	else {
		q = p;
		p->prior->next = p->next;
		p->next->prior = p->prior;
		delete q;
	}
} 
