package drawing;

public class GroupCommand extends Command{

	public GroupCommand(Drawing drawing) {
		super(drawing);
	}

	@Override
	public void execute() {
		 Group group = new Group();
         for (Shape shape : drawing) {
        	 if(shape.isSelected()){	
        		 group.addShape(shape);
        		 shape.unSelect();
 			}	    
         }
         drawing.addShape(group);
         for(Shape shape : group){
        	 drawing.removeShape(shape);
         }
	}
		
}


