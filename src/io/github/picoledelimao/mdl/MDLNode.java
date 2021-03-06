package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLBooleanArray;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public abstract class MDLNode extends MDLTVertexAnim {

	protected MDLNumber<Integer> objectId;
	protected MDLNumber<Integer> parentId;
	protected MDLBooleanArray dontInherit;
	protected MDLBoolean billboarded;
	protected MDLBoolean billboardedLockX;
	protected MDLBoolean billboardedLockY;
	protected MDLBoolean billboardedLockZ;
	protected MDLBoolean cameraAnchored;
	
	public MDLNode(String name) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(name);
		this.objectId = new MDLNumber<>("ObjectId", 0, true);
		this.parentId = new MDLNumber<>("Parent", -1, false);
		this.dontInherit = new MDLBooleanArray("DontInherit", "Translation", "Rotation", "Scaling");
		this.billboarded = new MDLBoolean("Billboarded");
		this.billboardedLockX = new MDLBoolean("BillboardedLockX");
		this.billboardedLockY = new MDLBoolean("BillboardedLockY");
		this.billboardedLockZ = new MDLBoolean("BillboardedLockZ");
		this.cameraAnchored = new MDLBoolean("CameraAnchored");
	}
	
	public int getObjectId() {
		return objectId.getValue();
	}
	
	public void setObjectId(int newObjectId) {
		this.objectId.setValue(newObjectId);
	}
	
	public int getParentId() {
		return parentId.getValue();
	}
	
	public void setParentId(int newParentId) {
		this.parentId.setValue(newParentId);
	}
	
	public MDLBoolean[] dontInherit() {
		return dontInherit.getValues();
	}
	
	public void setDontInherit(MDLBoolean[] values) {
		this.dontInherit.setValues(values);
	}
	
	public boolean isBillboarded() {
		return billboarded.getValue();
	}
	
	public void setBillboarded(boolean billboarded) {
		this.billboarded.setValue(billboarded);
	}
	
	public boolean isBillboardedLockX() {
		return billboardedLockX.getValue();
	}
	
	public void setBillboardedLockX(boolean billboardedLockX) {
		this.billboardedLockX.setValue(billboardedLockX);
	}

	public boolean isBillboardedLockY() {
		return billboardedLockY.getValue();
	}
	
	public void setBillboardedLockY(boolean billboardedLockY) {
		this.billboardedLockY.setValue(billboardedLockY);
	}
	
	public boolean isBillboardedLockZ() {
		return billboardedLockZ.getValue();
	}
	
	public void setBillboardedLockZ(boolean billboardedLockZ) {
		this.billboardedLockZ.setValue(billboardedLockZ);
	}
	
	public boolean isCameraAnchored() {
		return cameraAnchored.getValue();
	}
	
	public void setCameraAnchored(boolean cameraAnchored) {
		this.cameraAnchored.setValue(cameraAnchored);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, objectId, parentId, dontInherit, billboarded, billboardedLockX, 
				billboardedLockY, billboardedLockZ, cameraAnchored);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(objectId, parentId).append(sb).append(print(dontInherit, billboarded,
				billboardedLockX, billboardedLockY, billboardedLockZ, cameraAnchored)));
	}
	
}
