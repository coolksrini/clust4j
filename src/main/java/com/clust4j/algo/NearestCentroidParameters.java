/*******************************************************************************
 *    Copyright 2015, 2016 Taylor G Smith
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *******************************************************************************/

package com.clust4j.algo;

import java.util.Random;

import org.apache.commons.math3.linear.AbstractRealMatrix;

import com.clust4j.algo.preprocess.PreProcessor;
import com.clust4j.metrics.pairwise.GeometricallySeparable;

public class NearestCentroidParameters 
		extends BaseClustererParameters 
		implements SupervisedClassifierParameters<NearestCentroid> {
	
	private static final long serialVersionUID = -2064678309873097219L;
	private Double shrinkage = null;

	public NearestCentroidParameters() {
	}

	@Override
	public NearestCentroid fitNewModel(AbstractRealMatrix data, int[] y) {
		return new NearestCentroid(data, y, copy()).fit();
	}

	@Override
	public NearestCentroidParameters copy() {
		return new NearestCentroidParameters()
				.setNormalizer(norm)
				.setScale(scale)
				.setSeed(seed)
				.setMetric(metric)
				.setShrinkage(shrinkage)
				.setVerbose(verbose)
				.setForceParallel(parallel);
	}
	
	public Double getShrinkage() {
		return shrinkage;
	}

	@Override
	public NearestCentroidParameters setNormalizer(PreProcessor norm) {
		this.norm = norm;
		return this;
	}

	@Override
	public NearestCentroidParameters setForceParallel(boolean b) {
		this.parallel = b;
		return this;
	}

	@Override
	public NearestCentroidParameters setScale(boolean b) {
		this.scale = b;
		return this;
	}

	@Override
	public NearestCentroidParameters setSeed(Random rand) {
		this.seed = rand;
		return this;
	}

	public NearestCentroidParameters setShrinkage(final Double d) {
		this.shrinkage = d;
		return this;
	}

	@Override
	public NearestCentroidParameters setVerbose(boolean b) {
		this.verbose = b;
		return this;
	}

	@Override
	public NearestCentroidParameters setMetric(GeometricallySeparable dist) {
		this.metric = dist;
		return this;
	}

}