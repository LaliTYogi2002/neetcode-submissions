class MedianFinder {
    private List<Integer> list = new ArrayList<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            minHeap.add(num);
            return;
        }

        if(num >= minHeap.peek()){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }

        if(minHeap.size() > maxHeap.size() ){
            maxHeap.add(minHeap.poll());
        }else if(maxHeap.size() > minHeap.size() ){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return (double) minHeap.peek();
        }
        if(minHeap.size() < maxHeap.size()){
            return (double) maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
