package com.blz.hashmaptest.MyHashMap;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
	private final int numBuckets;
	ArrayList<MyLinkedList<K>> myBucketArray;

	public MyLinkedHashMap() {
		this.numBuckets = 10;
		this.myBucketArray = new ArrayList<>(numBuckets);
		// Creating empty LinkedLists
		for (int position = 0; position < numBuckets; position++)
			this.myBucketArray.add(null);
	}

	// This implements hash function to find index for a key
	private int getBucketsIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numBuckets;
		return index;
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		int index = this.getBucketsIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null)
			return null;
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	@SuppressWarnings("unchecked")
	public void add(K key, V value) {
		int index = this.getBucketsIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	public V remove(K key) {
		int index = this.getBucketsIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode != null) {
			myLinkedList.delete(myMapNode.getKey());
			return myMapNode.getValue();
		}
		return null;
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap List{" + myBucketArray + "}";
	}
}
