/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	private int wrong = 0;
	private GLine scaffold = new GLine(0,SCAFFOLD_HEIGHT,0,0);
	private GLine beam = new GLine(0,0,BEAM_LENGTH,0);
	private GLine rope = new GLine(BEAM_LENGTH,0,BEAM_LENGTH,ROPE_LENGTH);
	private GOval head = new GOval(BEAM_LENGTH-HEAD_RADIUS,ROPE_LENGTH,HEAD_RADIUS*2,HEAD_RADIUS*2);//前两个参数是外切矩形，后两个参数是外切矩形的长和宽
	private GLine body = new GLine(BEAM_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2,BEAM_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
	private GLine leftArmUpper = new GLine(BEAM_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH-UPPER_ARM_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
	private GLine leftArmLower = new GLine(BEAM_LENGTH-UPPER_ARM_LENGTH, ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD, BEAM_LENGTH-UPPER_ARM_LENGTH, ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
	private GLine rightArmUpper = new GLine(BEAM_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH+UPPER_ARM_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
	private GLine rightArmLower = new GLine(BEAM_LENGTH+UPPER_ARM_LENGTH, ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD, BEAM_LENGTH+UPPER_ARM_LENGTH, ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
	private GLine leftHip = new GLine(BEAM_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH,BEAM_LENGTH-HIP_WIDTH,ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
	private GLine leftLeg = new GLine(BEAM_LENGTH-HIP_WIDTH, ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH, BEAM_LENGTH-HIP_WIDTH, ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
	private GLine leftFoot = new GLine(BEAM_LENGTH-HIP_WIDTH,ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH,BEAM_LENGTH-HIP_WIDTH-FOOT_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
	private GLine rightHip = new GLine(BEAM_LENGTH, ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH, BEAM_LENGTH+HIP_WIDTH, ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
	private GLine rightLeg = new GLine(BEAM_LENGTH+HIP_WIDTH, ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH, BEAM_LENGTH+HIP_WIDTH, ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
	private GLine rightFoot = new GLine(BEAM_LENGTH+HIP_WIDTH,ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH,BEAM_LENGTH+HIP_WIDTH+FOOT_LENGTH,ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
	private GLabel label = new GLabel("",10,SCAFFOLD_HEIGHT+30);

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		this.wrong = 0;
		this.add(scaffold);
		this.add(beam);
		this.add(rope);
		this.add(head);
		this.add(body);
		this.add(leftArmUpper);
		this.add(leftArmLower);
		this.add(rightArmUpper);
		this.add(rightArmLower);
		this.add(leftHip);
		this.add(leftLeg);
		this.add(leftFoot);
		this.add(rightHip);
		this.add(rightLeg);
		this.add(rightFoot);
		this.add(label);

		head.setVisible(false);
		body.setVisible(false);
		leftArmUpper.setVisible(false);
		leftArmLower.setVisible(false);
		rightArmUpper.setVisible(false);
		rightArmLower.setVisible(false);
		leftHip.setVisible(false);
		leftLeg.setVisible(false);
		leftFoot.setVisible(false);
		rightHip.setVisible(false);
		rightLeg.setVisible(false);
		rightFoot.setVisible(false);

	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		this.label.setLabel(word);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		wrong++;
		switch(wrong){
			case 1:
				head.setVisible(true);
			break;
			case 2:
				body.setVisible(true);
			break;
			case 3:
				leftArmUpper.setVisible(true);
				leftArmLower.setVisible(true);
			break;
			case 4:
				rightArmUpper.setVisible(true);
				rightArmLower.setVisible(true);
			break;
			case 5:
				leftHip.setVisible(true);
				leftLeg.setVisible(true);
			break;
			case 6:
				rightHip.setVisible(true);
				rightLeg.setVisible(true);
			break;
			case 7:
				leftFoot.setVisible(true);
			break;
			case 8:
				rightFoot.setVisible(true);
			break;
		}
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
